package main.java.com.yuejin66.springframework.aop;

/**
 * @author lyj
 */
public class TargetSource {

    private final Object target;

    public Class<?>[] getTargetClass() {
        return target.getClass().getInterfaces();
    }

    public TargetSource(Object target) {
        this.target = target;
    }

    /* ---------- get/set ---------- */

    public Object getTarget() {
        return target;
    }
}
