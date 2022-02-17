package com.myproject.controller.command;

public enum PageAction {
    LOG_IN("login",new LoginCommand()),
    LOG_OUT("logout",new LogOutCommand()),
    REGISTER("register",new RegisterCommand()),
   // CHANGE_LANG("switchLang",new ChangeLocaleCommand());

    private final String action;
    private final Command command;

    PageAction(String action, Command command){
        this.action = action;
        this.command = command;
    }

    public String getAction() {

        return action;
    }

    public Command getCommand() {
        return command;
    }

    public static Command getCommand(String action){
        for (PageAction command: PageAction.values()) {
            if (command.getAction().equals(action)){
                return command.command;
            }
        }
        //todo return home page
        return null;
    }
}
