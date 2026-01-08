public class InsuranceScheme {

    private int schemeId;
    private String schemeName;
    private String schemeType;
    private int schemeDuration; // in years
    private double schemePremium;
    private double insuranceValue;
    private double returnOfInterest;

    public InsuranceScheme(int schemeId, String schemeName, String schemeType,
                           int schemeDuration, double schemePremium,
                           double insuranceValue, double returnOfInterest) {
        this.schemeId = schemeId;
        this.schemeName = schemeName;
        this.schemeType = schemeType;
        this.schemeDuration = schemeDuration;
        this.schemePremium = schemePremium;
        this.insuranceValue = insuranceValue;
        this.returnOfInterest = returnOfInterest;
    }

    public int getSchemeId() {
        return schemeId;
    }

    public void setSchemePremium(double schemePremium) {
        this.schemePremium = schemePremium;
    }

    @Override
    public String toString() {
        return "Scheme ID: " + schemeId +
                ", Name: " + schemeName +
                ", Type: " + schemeType +
                ", Duration: " + schemeDuration +
                ", Premium: " + schemePremium +
                ", Insurance Value: " + insuranceValue +
                ", ROI: " + returnOfInterest;
    }
}
