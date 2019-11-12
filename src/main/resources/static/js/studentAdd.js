layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#test'
        ,url:'/getListStudent'


        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }]
        ,title: '用户数据表'
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
            ,{field:'name', title:'姓名', width:100, edit: 'text'}
            ,{field:'age', title:'年龄', width:100, edit: 'text'}
            ,{field:'gradeid', title:'年级', width:150}
        ]]
        ,page: true
    });

    var form = layui.form;
    var layer = layui.layer;
    var add =
        '<form class="layui-form" action="">'+
        ' <div class="layui-form-item">'+
        '<label class="layui-form-label">学生姓名</label>'+
        '<div class="layui-input-inline">'+
        '<input type="text" name="title" required  lay-verify="required" placeholder="请输入学生姓名" autocomplete="off" class="layui-input" id="xname">'+
        '</div>'+
        '</div>'+
        '<div class="layui-form-item">'+
        '<label class="layui-form-label">学生年龄</label>'+
        '<div class="layui-input-inline">'+
        '<input type="text" name="title" required  lay-verify="required" placeholder="请输入学生年龄" autocomplete="off" class="layui-input" id="age">'+
        '</div>'+
        '</div>'+
        '<div class="layui-inline">'+
        '<label class="layui-form-label">学生年级</label>'+
        '<div class="layui-input-block">'+
        '<select name="interest" lay-filter="aihao" id="grade">'+
        '<option value="0">请选择年级</option>'+
        '<option value="1" >一年级</option>'+
        '<option value="2">二年级</option>'+
        '<option value="3">三年级</option>'+
        '<option value="4">四年级</option>'+
        '<option value="5">五年级</option>'+
        '</select>'+
        '</div>'+
        '</div>'+
        '<div class="layui-form-item">'+
        '<div class="layui-input-block">'+
        '<button class="layui-btn" lay-submit lay-filter="formDemo" id="student">立即提交</button>'+
        '</div></div>'+
    '</form>';

    $ = layui.jquery;

    $("#add").on('click', function() {
        layer.open({
            type : 1,
            title : "学生录入",
            skin : "myclass", // 自定样式
            area : [ "350px", "400px" ],
            content : add,

            success : function(layero, index) {
            },
            yes : function() {
            }
        });

        $('#student').click(function() {
            var xName=$('#xname').val();
            var age=$('#age').val();
            var gradeId=$('#grade').val();
            $.post('/studentAdd', {
                name : xName,
                age : age,
                gradeid:gradeId
            }, function(a,b) {
                alert(b.id);
            });
        });
        form.render(); // 动态渲染
    });
   /* laypage.render({
        elem: 'demo1'
        ,count: 20 //数据总数
        ,jump: function(obj){
            console.log(obj)
        }
    });*/
});
