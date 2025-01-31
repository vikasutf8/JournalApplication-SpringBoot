package CompanyName.ProjectName.service;

import CompanyName.ProjectName.Respository.JournalEntryRespository;
import CompanyName.ProjectName.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRespository journalEntryRespository; //dependency injection

    public  void saveEntry(JournalEntry journalEntry){
        journalEntryRespository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return  journalEntryRespository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
    return journalEntryRespository.findById(id);
    }
}
