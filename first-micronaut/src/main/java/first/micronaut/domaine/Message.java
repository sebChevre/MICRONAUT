package first.micronaut.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Message {

    Message(){}

    public Message(String msg) {
        this.msg = msg;
        this.date = new Date();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String msg;

    private Date date;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
