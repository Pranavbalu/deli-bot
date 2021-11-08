function buyItems() {
    var array = []
    var selectedItems = document.querySelectorAll('input[type=checkbox]:checked')

    for (var i = 0; i < selectedItems.length; i++) {
      array.push(selectedItems[i].value);
    }
    $.ajax({
        type: 'POST',
        url:'/buyItems',
        data: {
                'itemIds': array.join()
        },
        success: function(msg){
            alert(msg);
        }
    });



}

function changeDeliveryStatus() {
    var array = []
    var selectedItems = document.querySelectorAll('input[name=orderIds]:checked')

    for (var i = 0; i < selectedItems.length; i++) {
      array.push(selectedItems[i].value);
    }
    $.ajax({
        type: 'POST',
        url:'/changeDeliveryStatus',
        data: {
                'orderIds': array.join()
        },
        success: function(msg){
            alert(msg);
        }
    });



}


