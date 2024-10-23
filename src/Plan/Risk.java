package Plan;

import java.util.Objects;

public abstract class Risk {
     float premium;
    float coverage;
    float ceiling;

    private boolean isCovered(String[] riskedCovered, String[] claimed){
        int i=0;
        int j = 0;
        for(i=0;i<claimed.length;i++){
            for(j=0;j<riskedCovered.length;j++){
                if(Objects.equals(claimed[i], riskedCovered[j])){
                    break;
                }
                if(j==riskedCovered.length){
                    return false;
                }
            }
        }
        return true;
    }

    public abstract float getPremium();
    public abstract float getCoverage();
    public abstract float getCeiling();
}
