package first.micronaut.domaine.command;

import first.micronaut.domaine.Message;

public class CreateMessageCommand {

    private String msg;

    CreateMessageCommand(){}

    public CreateMessageCommand(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

    public Message toMessage(){
        return new Message(this.msg);
    }
}
