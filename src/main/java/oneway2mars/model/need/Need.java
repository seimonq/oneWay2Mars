package oneway2mars.model.need;

import javafx.util.Pair;
import oneway2mars.model.health.Health;

import java.util.Map;

public interface Need {

	/**
	 * scale between 1..10 how urgent a need has to be satisfied
	 *
	 * @return
	 */
	Float getUrgency();

	void setUrgency(Float urgency);

	/**
	 * determines how fast urgency raises
	 *
	 * @return
	 */
	Float getUrgencyRaiseFactor();

	void setUrgencyRaiseFactor();

	/**
	 * in case of satisfaction good and bad effect are stored for each {@link Health} type
	 *
	 * @return
	 */
	Map<Class<? extends Health>,Pair<Float,Float>> getSatisfactionMap();

	void setSatisfactionMap(Map<Class<? extends Health>,Pair<Float,Float>> satisfactionMap);

}
