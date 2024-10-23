package Plan;

public class AssistanceRisk extends Risk{
    @Override
    public float getPremium() {
        return 0.05f;
    }

    @Override
    public float getCoverage() {
        return 0.8f;
    }

    @Override
    public float getCeiling() {
        return 8;
    }

    public String[] AssistanceRisksCovered ={
            "Fire","Robbery","Transport","Car Replacement"
    };
}
