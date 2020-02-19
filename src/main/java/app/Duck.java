package app;

public class Duck extends Animal {
    public Duck( String name,String activity){
        this.name=name;
        this.activity=activity;
    }
    @Override
    public String  toString(){
        return "My name is "+name+" "+activity;
    }
}
