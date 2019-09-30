package clean_code.aircompany.Java.src.main.java.planes;



import clean_code.aircompany.Java.src.main.java.models.ClassificationLevel;
import clean_code.aircompany.Java.src.main.java.models.ExperimentalTypes;

import java.util.Objects;

public class ExperimentalPlane extends Plane {
    private ExperimentalTypes experimentalType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalTypes getExperimentalType() {
        return experimentalType;
    }

    public void setExperimentalType(ExperimentalTypes experimentalType) {
        this.experimentalType = experimentalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MilitaryPlane)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ExperimentalPlane that = (ExperimentalPlane) o;
        return experimentalType == that.experimentalType &&
                classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalType, classificationLevel);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "experimental experimentalType='" + experimentalType + '\'' +
                        "classification Level='" + classificationLevel +
                        '}');
    }
}
