package CompanyName.ProjectName.entity;

import java.lang.annotation.Documented;
import java.util.Date;

//how it show
@Documented(collection ="journal_entries")
public class JournalEntry {

    @Id
    private ObjectId id;
    private String title;
    private String content;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    private Date data;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ObjectId  getId() {
        return id;
    }

    public void setId(ObjectId  id) {
        this.id = id;
    }
}
