package landingpage.lm.mongo;

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

	public OccurrenceSet findSetByID(String id) {
		return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), OccurrenceSet.class);
	}

	public OccurrenceSet findSetByPID(String pid) {
		return mongoTemplate.findOne(Query.query(Criteria.where("pid").is(pid)), OccurrenceSet.class);
	}

	public void deleteByID(String id) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where("_id").is(id)), OccurrenceSet.class);
	}

	public void deleteByPID(String pid) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where("pid").is(pid)), OccurrenceSet.class);
	}

	public boolean existByID(String id) {
		return mongoTemplate.exists(Query.query(Criteria.where("_id").is(id)), OccurrenceSet.class);
	}

	public boolean existByPID(String pid) {
		return mongoTemplate.exists(Query.query(Criteria.where("pid").is(pid)), OccurrenceSet.class);
	}

}
