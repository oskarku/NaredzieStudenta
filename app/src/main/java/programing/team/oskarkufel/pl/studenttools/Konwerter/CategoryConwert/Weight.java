package programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert;

public class Weight {

    public static final String KEY_G="GR";
    public static final String KEY_KG="KG";
    public static final String KEY_DAG="DAG";
    public static final String KEY_T="TONA";

    private String typePrimary, goalConwertType;
    private float primaryNumber, gram, dag,kg,t, conwertNumber;




    public Weight (String typePrimary, float primaryNumber, String goalConwertType ){

        this.typePrimary = typePrimary;
        this.primaryNumber = primaryNumber;
        this.goalConwertType = goalConwertType;
        switch(typePrimary)
        {
            case KEY_G:
                this.gram=this.primaryNumber;
                this.dag = convertOtherCountWight(primaryNumber, KEY_G,KEY_DAG);
                this.kg = convertOtherCountWight(primaryNumber,KEY_G,KEY_KG);
                this.t= convertOtherCountWight(primaryNumber,KEY_G,KEY_T);
                break;
            case KEY_DAG:
                this.gram=convertOtherCountWight(primaryNumber, KEY_DAG,KEY_G);
                this.dag=primaryNumber;
                this.kg= convertOtherCountWight(primaryNumber,KEY_DAG,KEY_KG);
                this.t = convertOtherCountWight(primaryNumber, KEY_DAG,KEY_T);
                break;
            case KEY_KG:
                this.gram=convertOtherCountWight(primaryNumber,KEY_KG,KEY_G);
                this.dag=convertOtherCountWight(primaryNumber,KEY_KG,KEY_DAG);
                this.kg=primaryNumber;
                this.t=convertOtherCountWight(primaryNumber,KEY_KG,KEY_T);
                break;
            case KEY_T:
                this.gram=convertOtherCountWight(primaryNumber,KEY_T,KEY_G);
                this.dag=convertOtherCountWight(primaryNumber,KEY_T,KEY_DAG);
                this.kg=convertOtherCountWight(primaryNumber,KEY_T,KEY_KG);
                this.t=primaryNumber;
                break;

        }
    }

    public String getGoalConwertType() {
        return goalConwertType;
    }

    public float getConwertNumber() {
        switch(goalConwertType)
        {
            case KEY_G:
                conwertNumber=getGram();
                break;
            case KEY_DAG:
                conwertNumber=getDag();
                break;
            case KEY_KG:
                conwertNumber=getKg();
                break;
            case KEY_T:
                conwertNumber=getT();
                break;

        }
        return conwertNumber;
    }

    public float convertOtherCountWight (float valueN , String val1, String val2){
        float result=0;

        int[][] tableValue={{1,10,1000,1000*1000},{10,1,100,100*1000},{1000,100,1,1000},{1000*1000,100*1000,1000,1}};
        if(val1.equals(KEY_G)){

            if (val2.equals(KEY_G)){
                result = valueN;
            }

            else if(val2.equals(KEY_KG)){
                result = valueN/tableValue[0][2];
            }
            else if(val2.equals(KEY_DAG)){
                result=valueN/tableValue[0][1];
            }
            else if (val2.equals(KEY_T)){
                result = valueN/tableValue[0][3];
            }

        }

        else if (val1.equals(KEY_DAG)){

            if(val2.equals(KEY_G)){
                result=valueN*tableValue[1][0];
            }
            else  if (val2.equals(KEY_DAG)){
                result=valueN;
            }

            else if(val2.equals((KEY_KG))){
                result = valueN / tableValue[1][2];
            }
            else if (val2.equals(KEY_T)){
                result = valueN / tableValue[1][3];
            }

        }

        else if (val1.equals(KEY_KG)){

            if(val2.equals(KEY_G)){
                result=valueN*tableValue[2][0];
            }

            else if (val2.equals(KEY_DAG)){
                result=valueN*tableValue[2][1];
            }

            else if (val2.equals(KEY_T)){
                result = valueN/tableValue[2][3];
            }

        }

        else if(val1.equals((KEY_T))){
            if(val2.equals(KEY_KG)){
                result=valueN*tableValue[3][2];

            }
            else if (val2.equals((KEY_DAG))){
                result=valueN*tableValue[3][1];
            }

            else if (val2.equals(KEY_G)){
                result = valueN*tableValue[3][0];
            }

            else if (val2.equals(KEY_T)){
                result = valueN;
            }
        }

        return result;
    }


    public float getGram() {
        return gram;
    }

    public float getDag() {
        return dag;
    }

    public float getKg() {
        return kg;
    }

    public float getT() {
        return t;
    }
}
