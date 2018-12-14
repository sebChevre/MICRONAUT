package first.micronaut.domaine.command;

import first.micronaut.domaine.Message;
import org.springframework.context.ApplicationEvent;

public class CreateMessageCommand extends ApplicationEvent {

    private String msg;

    CreateMessageCommand(){super("");}

    public CreateMessageCommand(String msg){
        super("");
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

    public Message toMessage(){
        return new Message(this.msg);
    }

    @Override
    public String toString() {
        return "CreateMessageCommand{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
