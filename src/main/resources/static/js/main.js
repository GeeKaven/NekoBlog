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
            }
        })
    },
    deleted : function (post_id) {
        if (confirm("是否删除")) {
            $.ajax({
                url: '/api/admin/post/delete/' + post_id,
                type: 'DELETE',
                success: function () {
                    alert("删除成功");
                    window.location.reload();
                }
            })
        }
    },
    published: function (post_id) {
        if (confirm("是否发布")) {
            $.ajax({
                url: '/api/admin/post/publish/' + post_id,
                type: 'PUT',
                success: function () {
                    alert("发布成功");
                    window.location.reload();
                }
            })
        }
    }
};