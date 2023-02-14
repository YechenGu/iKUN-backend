

/**
 * @Author iKUN
 * @Date 2023/1/5 12:22
 * @Description TODO
 * @Version 1.0
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = iKUNApplication.class)
public class BatchInsertInfoTest {


    public static String[] company = {"北京字节跳动科技有限公司","作业帮教育科技有限公司","北京群鲜荟萃科技有限公司","湖南顺丰速运有限公司","湖南优积谷网络科技有限公司","湖南蜂匠信息科技有限公司","湖南强智科技发展有限公司"};
    public static String[] post = {"java开发高级工程师","美工","经理助理","Andorid开发工程师","测试工程师","互联网产品经理","互联网运维工程师"};

    @Resource
    private IImsPracticeService practiceService;
    @Resource
    private SysUserMapper userMapper;


    @Test
    public void test(){
        List<SysUser> sysUsers = userMapper.selectUserList(new SysUser());
        sysUsers = sysUsers.parallelStream().filter(o -> 200 < o.getDeptId()).collect(Collectors.toList());
        for (int i = 0; i < 30; i++) {
            Random random = new Random();
            int i1 = random.nextInt(2000);
            ImsPractice imsPractice = new ImsPractice();
            Long userId = sysUsers.get(i1).getUserId();
            imsPractice.setUserId(userId);
        }
    }
}*/
