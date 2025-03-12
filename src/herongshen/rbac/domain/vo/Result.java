package herongshen.rbac.domain.vo;

public class Result {
    public boolean success;
    public String message;
    public Object data;
    public static Result failure(String message) {
        Result result = new Result();
        result.message = message;
        return result;
    }
    public static Result success(String message, Object data) {
        Result result = new Result();
        result.success = true;
        result.message = message;
        result.data = data;
        return result;
    }
}
