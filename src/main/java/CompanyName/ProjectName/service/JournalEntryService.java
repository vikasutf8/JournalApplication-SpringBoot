package CompanyName.ProjectName.service;

import CompanyName.ProjectName.Respository.JournalEntryRespository;
import CompanyName.ProjectName.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;

public class journalEntryService {
    @Autowired
    private JournalEntryRespository journalEntryRespository; //dependency injection

    public  void saveEntry(JournalEntry journalEntry){
        journalEntryRespository.save(journalEntry);
    }
}
