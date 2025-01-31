package CompanyName.ProjectName.Respository;

import CompanyName.ProjectName.entity.JournalEntry;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;

public interface JournalEntryRespository  extends MongoRepository<JournalEntry,ObjectId >{

}
