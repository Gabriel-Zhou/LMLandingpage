package landingpage.lm.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import landingpage.lm.container.OccurrenceSet;

@Repository
public class OccurrenceRepository {

	public static final String COLLECTION_NAME = "OccurrenceSet";

	@Autowired
	private MongoTemplate mongoTemplate;

	public void addSet(OccurrenceSet set) {
		if (!mongoTemplate.collectionExists(OccurrenceSet.class)) {
			mongoTemplate.createCollection(OccurrenceSet.class);
		}

		mongoTemplate.insert(set, COLLECTION_NAME);
	}

	public List<OccurrenceSet> listAll() {
		return mongoTemplate.findAll(OccurrenceSet.class);
	}

	public OccurrenceSet findSetByID(String id) {
		return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), OccurrenceSet.class);
	}

	public OccurrenceSet findSetByInternalID(String internalID) {
		return mongoTemplate.findOne(Query.query(Criteria.where("internalID").is(internalID)), OccurrenceSet.class);
	}

	public void deleteByID(String id) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where("_id").is(id)), OccurrenceSet.class);
	}

	public void deleteByInternalID(String internalID) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where("internalID").is(internalID)), OccurrenceSet.class);
	}

	public boolean existByID(String id) {
		return mongoTemplate.exists(Query.query(Criteria.where("_id").is(id)), OccurrenceSet.class);
	}

	public boolean existByInternalID(String internalID) {
		return mongoTemplate.exists(Query.query(Criteria.where("internalID").is(internalID)), OccurrenceSet.class);
	}

	public boolean existByPID(String pid) {
		return mongoTemplate.exists(Query.query(Criteria.where("pid").is(pid)), OccurrenceSet.class);
	}

	public OccurrenceSet findSetByPID(String pid) {
		return mongoTemplate.findOne(Query.query(Criteria.where("pid").is(pid)), OccurrenceSet.class);
	}
}
