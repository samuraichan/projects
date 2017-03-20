$(document).ready(function() {
	
    $('#pagination').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": {
          "url": "/starter/pagination",
          "type": "POST",
          "data": function (d) {
            return $.extend( {}, d, {
              "searchFilter.statusId": $('#status option:selected').val(),
              "searchFilter.startDate": $('#startDate').val(),
              "searchFilter.endDate": $('#endDate').val(),
            });
          }
        },
        "columns": [
          { data: 'namedInsured'},
          { data: 'status'},
          { data: 'createdDateString'}
        ]
    });
} );

