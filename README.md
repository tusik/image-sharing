# 图床程序-jsp&servlet

## Describe

这是使用jsp和servlet编写的图床程序，目前Beta版本只实现了基本功能，等待完善。

### NEEDS

- commons-configuration2
- commons-codec
- commons-lang3

## Change log

### v0.0.5(16.10.2)

- 增加对上传文件的md5检测，判断是否为重复文件
- 增加数据库支持,酱文件记录进mysql
- 增加程序的配置文件

### V0.0.1(16.10.1)

- 基本上传功能
- 对当天的文件放置于（年月日）文件夹内，如2016101