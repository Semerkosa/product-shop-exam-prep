package demo.shoppinglist.models.service;

public abstract class BaseServiceModel {

    private String id;

    public String getId() {
        return id;
    }

    public BaseServiceModel setId(String id) {
        this.id = id;
        return this;
    }
}
