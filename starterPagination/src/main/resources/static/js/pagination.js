$(document).ready(function() {
	
    var table = $('#pagination').DataTable( {
        "processing": true,
        "serverSide": true,
        "searching":   false,
        "ajax": {
          "url": "/starter/pagination",
          "type": "POST",
          "data": function (d) {
            return $.extend( {}, d, {
              "searchFilter.statusId": $('#status option:selected').val(),
              "searchFilter.startDate": $('#startDate').val(),
              "searchFilter.endDate": $('#endDate').val(),
              "search": $('#mySearch').val()
            });
          }
        },
        "columns": [
          { data: 'namedInsured'},
          { data: 'status'},
          { data: 'createdDateString'}
        ]
    });
    
    $('#btn').on('click', function() {
      table.draw();
    });
} );

