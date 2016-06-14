package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class JSONUtils.
 * <p>
 * Utility class containing helper methods to deal with conversion to and from JSON to POJOs.
 */
public final class JsonToPojoConverter {

    /** The log. */
    private static final Logger LOG = LoggerFactory
        .getLogger(JsonToPojoConverter.class);

    /** The error message displayed when a an object fails to be converted. */
    private static final String COULD_NOT_CONVERT_TO_JSON =
        "Could not convert to JSON";

    /**
     * Private constructor enforcing the static factory pattern.
     */
    private JsonToPojoConverter() {

    }

    /**
     * Convert the given POJO into a String in JSON format.
     * 
     * @param <T>
     *            the generic type of the pojo
     * @param pojo
     *            the pojo to be converted into JSON
     * @return the string representation of the pojo
     */
    public static <T> String convertToJson(T pojo) {
        ObjectMapper mapper = new CustomJacksonObjectMapper();

        try {
            return mapper.writeValueAsString(pojo);
        } catch (JsonGenerationException e) {
            LOG.error(COULD_NOT_CONVERT_TO_JSON, e);
            return null;
        } catch (JsonMappingException e) {
            LOG.error(COULD_NOT_CONVERT_TO_JSON, e);
            return null;
        } catch (IOException e) {
            LOG.error(COULD_NOT_CONVERT_TO_JSON, e);
            return null;
        }
    }

    /**
     * Convert the given JSON into a POJO of type T.
     * 
     * @param <T>
     *            the generic type of the POJO to be created
     * @param json
     *            the JSON string being mapped to a POJO
     * @param type
     *            the type
     * @return the t
     */
    public static <T> T convertFromJson(String json, Class<T> type) {

        ObjectMapper mapper = new CustomJacksonObjectMapper();
        try {
            return mapper.readValue(json, type);
        } catch (JsonGenerationException e) {
            LOG.error(COULD_NOT_CONVERT_TO_JSON, e);
            return null;
        } catch (JsonMappingException e) {
            LOG.error(COULD_NOT_CONVERT_TO_JSON, e);
            return null;
        } catch (IOException e) {
            LOG.error(COULD_NOT_CONVERT_TO_JSON, e);
            return null;
        }
    }

    /**
     * Convert the given JSON into a POJO of type T.
     * 
     * @param <T>
     *            the generic type of the POJO to be created
     * @param json
     *            the JSON string being mapped to a POJO
     * @param typeReference
     *            the type reference
     * @return the t
     */
    public static <T> T convertFromJson(String json,
        TypeReference<T> typeReference) {

        ObjectMapper mapper = new CustomJacksonObjectMapper();
        try {
            return mapper.readValue(json, typeReference);
        } catch (JsonGenerationException e) {
            LOG.error(COULD_NOT_CONVERT_TO_JSON, e);
            return null;
        } catch (JsonMappingException e) {
            LOG.error(COULD_NOT_CONVERT_TO_JSON, e);
            return null;
        } catch (IOException e) {
            LOG.error(COULD_NOT_CONVERT_TO_JSON, e);
            return null;
        }
    }

    /**
     * Read the file to string.
     * 
     * @param fileName
     *            of file located in directory of the current project
     * @return the file as a JSON string
     */
    public static String readFileToString(String fileName) {
        String json = null;
        try {
            File file = new File(System.getProperty("user.dir") + fileName);
            json = FileUtils.readFileToString(file);
        } catch (IOException e) {
            LOG.error("Failed to read file to String", e);
            return null;
        }
        return json;
    }
}
