package utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * The Class CustomJacksonObjectMapper.
 */
public class CustomJacksonObjectMapper extends ObjectMapper {

    /** The pretty print. */
    private boolean prettyPrint = true;

    /**
     * We want a little control of Jackson.
     */
    public CustomJacksonObjectMapper() {
        // // handling serialisation
        this.configure(Feature.INDENT_OUTPUT, true);
        this.setSerializationInclusion(Inclusion.ALWAYS);

        this.configure(
            org.codehaus.jackson.map.DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,
            true);
    }

    /**
     * Checks if is pretty print.
     * 
     * @return true, if is pretty print
     */
    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    /**
     * Sets the pretty print.
     * 
     * @param prettyPrint
     *            the new pretty print
     */
    public void setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
    }
}
