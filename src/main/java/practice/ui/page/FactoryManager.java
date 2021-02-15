package practice.ui.page;

public class FactoryManager {

    private static ThreadLocal<PageClassFactory> pageClassFactoryThreadLocal = new ThreadLocal<>();

    private FactoryManager() {
    }

    public static PageClassFactory getPageClassFactory() {
        return pageClassFactoryThreadLocal.get();
    }

    public static void registerPageClassFactory(PageClassFactory pageClassFactory) {
        pageClassFactoryThreadLocal.set(pageClassFactory);
    }

    public static void removePageClassFactory() {
        pageClassFactoryThreadLocal.remove();
    }


}
