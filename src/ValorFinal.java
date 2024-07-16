public class ValorFinal {

    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double value;
    private double result;

    public ValorFinal(CurrencyOmdb currencyOmdb, double Value){

        this.base_code=currencyOmdb.base_code();
        this.target_code=currencyOmdb.target_code();
        this.conversion_rate=currencyOmdb.conversion_rate();
        this.value=Value;
        this.result= value* this.conversion_rate;
    }



    @Override
    public String toString() {
        return " The value of "+ value +
                " [" +base_code +"]" + " corresponds to the final value of:  "
                +result +" [" +target_code + "]";
    }
}
