package com.jimbo.ach;

import java.util.Date;
import java.util.List;

public class AchResponse {
    public Date timestamp;
    public String traceCode;
    public AchStatus status;
    public List<String> errorMessage;
}
