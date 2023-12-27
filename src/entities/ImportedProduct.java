package entities;

public class ImportedProduct extends Product{
    private Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public ImportedProduct setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
        return this;
    }

    public double totalPrice (){
        return getPrice()+customsFee;
    }

    @Override
    public String priceTag() {
        StringBuilder sb= new StringBuilder();
        sb.append(getName());
        sb.append(" $ ");
        sb.append(String.format("%.2f", totalPrice()));
        sb.append(" (Customs fee: $ ");
        sb.append(String.format("%.2f", customsFee));
        sb.append(")");
        return sb.toString();
    }
}
