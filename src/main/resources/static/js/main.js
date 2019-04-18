let post = {
    add : function () {
        let data = {
            "title": $("#post-title").val(),
            "content": $("#post-content").val()
        };
        console.info(data);
        let json = JSON.stringify(data);
        $.ajax({
            url: '/api/admin/post/create',
            type: 'POST',
            data: json,
            contentType: 'application/json',
            success: function () {
                alert("提交成功");
                window.location.href = '/admin/post/list'
            },
            error: function () {
                alert("提交失败");
            }
        })
    }
};