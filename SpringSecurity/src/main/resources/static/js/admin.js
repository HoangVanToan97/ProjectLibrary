$(document).ready(function(){
		   var columnDefinitions = [
		    	{
		    		"data":"id",
		    		"class": "text-center",
		            "orderable": false
		    	},
		    	{
		    		"data":"username",
		    		"class": "text-center",
		    	},
		        {
		            "data": "role",
		            "defaultContent": ""
		        },
		        {
		            "data": "enabled",
		            "class": "text-center"
		        },
		        {
		            "data": "id",
		            "class": "text-center"
		        }
		        
		    ];

		   var dataTable = $('#content_table').DataTable({
		        "ordering": true,
		        "serverSide": true,
		        "order": [0, "desc"],
		        "searching": false,
		        "ajax": 'json',
		        "ajax": {
		            url: "/api/v1/web/admin/listUser",
		            type: 'GET',
		            dataSrc:""
		        },
		        "columns": columnDefinitions,
		        "lengthMenu": [
		            [50, 100, 200],
		            [50, 100, 200]
		        ],
		        columnDefs: [
		        	{
		        		"render": function (data) {
		                    return "<input class='check' type= 'checkbox' style='width: 15px, height: 15px' />";
		                },
		                "targets": 0
		        	}
		        ]

		    });
	   })