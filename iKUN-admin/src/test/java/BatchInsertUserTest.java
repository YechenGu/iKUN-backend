

/**
 * @Author iKUN
 * @Date 2023/1/5 10:46
 * @Description TODO
 * @Version 1.0
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = iKUNApplication.class)
public class BatchInsertUserTest {
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private SysDeptMapper deptMapper;
    @Resource
    private SysUserRoleMapper userRoleMapper;
    @Resource
    private ISysConfigService configService;

    private static String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
    private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    private static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

    private static String getChineseName() {
        int index=getNum(0, firstName.length()-1);
        String first=firstName.substring(index, index+1);
        int sex=getNum(0,1);
        String str=boy;
        int length=boy.length();
        if(sex==0){
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);
        String second=str.substring(index, index+1);
        int hasThird=getNum(0,1);
        String third="";
        if(hasThird==1){
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;
    }

    @Test
    public void test(){
        SysDept dept = new SysDept();
        dept.setDeptType(ImsConstants.DEPT_TYPE_CLASS);
        List<SysDept> sysDepts = deptMapper.selectDeptList(dept);
        if (null != sysDepts){
            for (SysDept sysDept : sysDepts) {
                Long deptId = sysDept.getDeptId();
                if (253 < deptId){
                    String orderNum = sysDept.getOrderNum();
                    SysUser user = new SysUser();
                    user.setDeptId(deptId);
                    Random random = new Random();
                    int i1 = random.nextInt(100);
                    String password = configService.selectConfigByKey("sys.user.initPassword");
                    for (int i = 1; i < 41; i++) {
                        user.setUserName("17"+ String.format("%02d",i1) + "0" + orderNum+String.format("%02d",i));
                        user.setNickName(getChineseName());
                        user.setPassword(SecurityUtils.encryptPassword(password));
                        user.setSex(String.valueOf(getNum(0,1)));
                        user.setPhonenumber("1886666"+String.format("%02d",i1)+String.format("%02d",i));
                        user.setEmail(user.getUserName()+"@qq.com");
                        user.setStatus("0");
                        userMapper.insertUser(user);
                        Long userId = user.getUserId();
                        SysUserRole ur = new SysUserRole();
                        ur.setRoleId(100L);
                        ur.setUserId(userId);
                        List<SysUserRole> list = new ArrayList<SysUserRole>();
                        list.add(ur);
                        userRoleMapper.batchUserRole(list);
                    }
                }
            }
        }

    }

    @Test
    public void test1(){
        SysUser user = new SysUser();
        user.setPassword("123456");
        List<SysUser> sysUsers = userMapper.selectUserList(user);
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (SysUser sysUser : sysUsers) {
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            userMapper.updateUser(sysUser);
        }
    }
}*/
