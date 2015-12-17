package landingpage.lm.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import landingpage.lm.container.ProjectionSet;

@Repository
public class ProjectionRepository {
	public static final String COLLECTION_NAME = "ProjectionSet";

	@Autowired
	private MongoTemplate mongoTemplate;

	public void addSet(ProjectionSet set) {
		if (!mongoTemplate.collectionExists(ProjectionSet.class)) {
			mongoTemplate.createCollection(ProjectionSet.class);
		}

		mongoTemplate.insert(set, COLLECTION_NAME);
	}

	public ProjectionSet findSetByID(String id) {
		return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), ProjectionSet.class);
	}

	public ProjectionSet findSetByPID(String pid) {
		return mongoTemplate.findOne(Query.query(Criteria.where("pid").is(pid)), ProjectionSet.class);
	}

	public void deleteByID(String id) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where("_id").is(id)), ProjectionSet.class);
	}

	public void deleteByPID(String pid) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where("pid").is(pid)), ProjectionSet.class);
	}

	public boolean existByID(String id) {
		return mongoTemplate.exists(Query.query(Criteria.where("_id").is(id)), ProjectionSet.class);
	}

	public boolean existByPID(String pid) {
		return mongoTemplate.exists(Query.query(Criteria.where("pid").is(pid)), ProjectionSet.class);
	}
}
