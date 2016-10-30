package springboot.chapter3.conditional_4;

/**
 * Created by mike on 2016/10/29.
 */
public class WindowsListService implements ListService{
    @Override
    public String showCmds() {
        return "dir";
    }
}
