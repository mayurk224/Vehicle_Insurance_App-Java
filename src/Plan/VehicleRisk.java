package Plan;

public class VehicleRisk extends Risk{

    @Override
    public float getPremium() {
        return 0.05f;
    }

    @Override
    public float getCoverage() {
        return 0.9f;
    }

    @Override
    public float getCeiling() {
        return 6f;
    }

    public String[] ObligatoryRisksCovered ={
            "Vehicle Damage"
    };
}
