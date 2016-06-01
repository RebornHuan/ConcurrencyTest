import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * IP工具类
 * @author lyh
 * @version 2012-7-5
 * @see IpGetter
 * @since
 */
public class IpGetter
{
    /**
     * 单网卡名称
     */
    private static final String NETWORK_CARD = "eth0";

    /**
     * 绑定网卡名称
     */
    private static final String NETWORK_CARD_BAND = "bond0";

    /**
     * 
     * Description: 得到本机名<br>
     * @return 
     * @see
     */
    public static String getLocalHostName()
    {
        try
        {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostName();
        }
        catch (Exception e)
        {
            System.out.println("IpGetter.getLocalHostName出现异常！异常信息：" + e.getMessage());
            return "";
        }
    }

    /**
     * Description: linux下获得本机IPv4 IP<br>
     * @return 
     * @see
     */
    public static String getLocalIP()
    {
        String ip = "";
        try
        {
            Enumeration<NetworkInterface> e1 = (Enumeration<NetworkInterface>)NetworkInterface.getNetworkInterfaces();
            while (e1.hasMoreElements())
            {
                NetworkInterface ni = e1.nextElement();

                //单网卡或者绑定双网卡
                if ((NETWORK_CARD.equals(ni.getName()))
                    || (NETWORK_CARD_BAND.equals(ni.getName())))
                {
                    Enumeration<InetAddress> e2 = ni.getInetAddresses();
                    while (e2.hasMoreElements())
                    {
                        InetAddress ia = e2.nextElement();
                        if (ia instanceof Inet6Address)
                        {
                            continue;
                        }
                        ip = ia.getHostAddress();
                    }
                    break;
                }
                else
                {
                    continue;
                }
            }
        }
        catch (SocketException e)
        {
            System.out.println("IpGetter.getLocalIP出现异常！异常信息：" + e.getMessage());
        }
        return ip;
    }
    public static void main(String[] args) {
//        IpGetter ipGetter =new IpGetter();
        String str = IpGetter.getLocalIP();
        System.out.println("ip++++++++++++++"+str);
    }

}