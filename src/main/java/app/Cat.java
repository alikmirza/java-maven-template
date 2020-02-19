package app;

public class Cat extends Animal {
    public Cat(String name,String activity ){
        this.name=name;
        this.activity=activity;
    }
    @Override
    public String  toString(){
        return "My name is "+name+" "+activity;
    }
}
