package CompanyName.ProjectName.Controller;

import CompanyName.ProjectName.Respository.JournalEntryRespository;
import CompanyName.ProjectName.entity.JournalEntry;
import CompanyName.ProjectName.service.JournalEntryService;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
        //where store
//        private Map<Long, JournalEntry> journalEntries  =new HashMap<>();

        @Autowired
        private JournalEntryService journalEntryService; //instance created by spring and we inject it


        @GetMapping
        public List<JournalEntry>  getAll(){
             return JournalEntryService.getAll();
        }

        @PostMapping
        public void createEntry(@RequestBody JournalEntry myEntry){ //http://localhost:8080/journal -POST
//now field or journalEntry created send in this fn ,insteans created
//            journalEntries.put(myEntry.getId(),myEntry);
                myEntry.setData(LocalDate.now());
                journalEntryService.saveEntry(myEntry);
                return myEntry;
        }

        @GetMapping("/id/{myId}")
        public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId).orElse(null);
        }
//

}
