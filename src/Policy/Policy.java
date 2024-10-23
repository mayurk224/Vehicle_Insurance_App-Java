package Policy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Policy implements Serializable {
    static int policyNB = 0;
    Vehicle vehicle;
    List<String> riskCoveredLIST = new ArrayList<>();
    List<Float> premiumLIST = new ArrayList<>();
    List<Float> ceilingLIST = new ArrayList<>();
    int validityYear;
    LocalDate policyDate;

    public Policy(Vehicle vehicle, List<String> riskCoveredLIST, List<Float> premiumLIST, List<Float> ceilingLIST, int validityYear, LocalDate policyDate) {
        this.vehicle = vehicle;
        this.riskCoveredLIST = riskCoveredLIST;
        this.premiumLIST = premiumLIST;
        this.ceilingLIST = ceilingLIST;
        this.validityYear = validityYear;
        this.policyDate = policyDate;
        policyNB+=1;
    }

    public static int getPolicyNB() {
        return policyNB;
    }

    public static void setPolicyNB(int policyNB) {
        Policy.policyNB = policyNB;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<String> getRiskCoveredLIST() {
        return riskCoveredLIST;
    }

    public void setRiskCoveredLIST(List<String> riskCoveredLIST) {
        this.riskCoveredLIST = riskCoveredLIST;
    }

    public List<Float> getPremiumLIST() {
        return premiumLIST;
    }

    public void setPremiumLIST(List<Float> premiumLIST) {
        this.premiumLIST = premiumLIST;
    }

    public List<Float> getCeilingLIST() {
        return ceilingLIST;
    }

    public void setCeilingLIST(List<Float> ceilingLIST) {
        this.ceilingLIST = ceilingLIST;
    }

    public int getValidityYear() {
        return validityYear;
    }

    public void setValidityYear(int validityYear) {
        this.validityYear = validityYear;
    }

    public LocalDate getPolicyDate() {
        return policyDate;
    }

    public void setPolicyDate(LocalDate policyDate) {
        this.policyDate = policyDate;
    }

    @Override
    public String toString(){
        return "Policy NB: " +policyNB+
                "\n" +vehicle+
                "\nValidity Year:" +validityYear;
    }
}
