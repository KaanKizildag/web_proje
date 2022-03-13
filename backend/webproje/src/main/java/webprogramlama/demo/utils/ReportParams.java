package webprogramlama.demo.utils;

import org.springframework.context.annotation.Description;

@Description(value = "Report Params Constants.")
public final class ReportParams {

    public static final String PARAM_FIRST_NAME         = "TITLE";
    public static final String PARAM_LAST_NAME          = "DESCRIPTION";
    public static final String PARAM_AGE                = "ID";
    public static final String PARAM_CUSTOM_DATA_SOURCE = "CUSTOM_SOURCE_DATA";

    /**
     * Private constructor - can not be instantiated.
     */
    private ReportParams() { }
}
