
$(function () {
	$('body').on('click', '.list-group .list-group-item', function () {
		$(this).toggleClass('active_list');
    });
	
	$('button').click(function () {
	    var $button = $(this), actives = '';
	    if ($button.hasClass('move-left')) {
	        actives = $('.list-right ul li.active_list');
	        actives.each(function(){
	        	if($(this).css("display") != "none")
	        	{
	        		$(this).clone().appendTo('.list-left ul');
	        		$(this).remove();
	        	}
	        });
	    } else if ($button.hasClass('move-right')) {
	        actives = $('.list-left ul li.active_list');
	        actives.each(function(){
	        	if($(this).css("display") != "none")
	        	{
	        		$(this).clone().appendTo('.list-right ul');
	        		$(this).remove();
	        	}
	        });
	    }
	});
	
    $('.dual-list .selector').click(function () {
        var $checkBox = $(this);
        if (!$checkBox.hasClass('selected')) {
            $checkBox.addClass('selected').closest('.well').find('ul li:not(.active_list)').each(function(){
            	if($(this).css("display") != "none")
            		$(this).addClass('active_list');
            });
            
            $checkBox.children('i').each(function(){
            	if($(this).css("display") != "none")
            		$(this).removeClass('glyphicon-unchecked').addClass('glyphicon-check');
            });
            
        } else {
            $checkBox.removeClass('selected').closest('.well').find('ul li.active_list').each(function(){
            	if($(this).css("display") != "none")
            		$(this).removeClass('active_list');
            });
            $checkBox.children('i').each(function(){
            	if($(this).css("display") != "none")
            		$(this).removeClass('glyphicon-check').addClass('glyphicon-unchecked');
            });
        }
    });
    $('[name="SearchDualList"]').keyup(function (e) {
        var code = e.keyCode || e.which;
        if (code == '9') return;
        if (code == '27') $(this).val(null);
        var $rows = $(this).closest('.dual-list').find('.list-group li');
        var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
        $rows.show().filter(function () {
            var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
            return !~text.indexOf(val);
        }).hide();
    });
    
});
	

  