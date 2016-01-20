package landingpage.lm.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import landingpage.lm.container.VMObject;

@Repository
public class VMRepository {
	public static final String COLLECTION_NAME = "VMObject";

	@Autowired
	private MongoTemplate mongoTemplate;

	public void addVM(VMObject vmobject) {
		if (!mongoTemplate.collectionExists(VMObject.class)) {
			mongoTemplate.createCollection(VMObject.class);
		}

		mongoTemplate.insert(vmobject, COLLECTION_NAME);
	}

	public List<VMObject> listAll() {
		return mongoTemplate.findAll(VMObject.class);
	}

	public VMObject findObjectByID(String id) {
		return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), VMObject.class);
	}

	public VMObject findObjectByInternalID(String internalID) {
		return mongoTemplate.findOne(Query.query(Criteria.where("internalID").is(internalID)), VMObject.class);
	}

	public void deleteByID(String id) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where("_id").is(id)), VMObject.class);
	}

	public void deleteByInternalID(String internalID) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where("internalID").is(internalID)), VMObject.class);
	}

	public boolean existByID(String id) {
		return mongoTemplate.exists(Query.query(Criteria.where("_id").is(id)), VMObject.class);
	}

	public boolean existByInternalID(String internalID) {
		return mongoTemplate.exists(Query.query(Criteria.where("internalID").is(internalID)), VMObject.class);
	}

	public boolean existByPID(String pid) {
		return mongoTemplate.exists(Query.query(Criteria.where("pid").is(pid)), VMObject.class);
	}

	public VMObject findObjectByPID(String pid) {
		return mongoTemplate.findOne(Query.query(Criteria.where("pid").is(pid)), VMObject.class);
	}
}
