package CompanyName.ProjectName.Controller;

import CompanyName.ProjectName.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {
        //where store
        private Map<Long, JournalEntry> journalEntries  =new HashMap<>();

        @GetMapping
        public List<JournalEntry> getAll(){ //http://localhost:8080/-GET
            return new ArrayList<>(journalEntries.values());
        }

        @PostMapping
        public void createEntry(@RequestBody JournalEntry myEntry){ //http://localhost:8080/journal -POST
//now field or journalEntry created send in this fn ,insteans created
            journalEntries.put(myEntry.getId(),myEntry);
        }
//
        @GetMapping("/id/{myid}")
        public  JournalEntry getJournalEntryById(@PathVariable Long myid){
            return journalEntries.get(myid);
        }

        @DeleteMapping("/id/{myid}")
        public  JournalEntry deleteJournalEntryById(@PathVariable Long myid){
            return journalEntries.remove(myid);
        }

        @PutMapping
        public  JournalEntry updateJournalEntryById(@PathVariable Long id ,@RequestBody JournalEntry myEntry){
            return journalEntries.put(id,myEntry);
        }
}
