# revolut-backend

Design and implement a RESTful API (including data model and the backing implementation) for money
transfers between accounts.

Used tools, libraries and frameworks:
- Spring framework, Spring Boot
- Maven

API Manual

## API Manual
<table>
    	<thead>
    	<tr>
    		<th>Recourse</th>
    		<th>URI</th>
    		<th>Method</th>
    	</tr>
        <tr>
            <th colspan=3>Accounts</th>
        </tr>
    	<tr>
    		<td>List of all accounts</td>
    		<td> http://localhost:8080/webapi/accounts </td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Find particular account</td>
    		<td> http://localhost:8080/webapi/accounts/{accountID} </td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Adding new account</td>
    		<td> http://localhost:8080/webapi/accounts </td>
    		<td>POST</td>
    	</tr>
    	<tr>
    		<td>Updating an account</td>
    		<td> http://localhost:8080/webapi/accounts/{accountID} </td>
    		<td>PUT</td>
    	</tr>
    	<tr>
    		<td>Deleting an account</td>
    		<td> http://localhost:8080/webapi/accounts/{accountID} </td>
    		<td>DELETE</td>
    	</tr>
    	<tr>
    		<th colspan=3>Transfers</th>
    	</tr>
    	<tr>
    		<td>List of transfer history</td>
    		<td> http://localhost:8080/webapi/transfers </td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Account transfer history</td>
    		<td> http://localhost:8080/webapi/transfers/{accountID} </td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Make a new transfer</td>
    		<td> http://localhost:8080/webapi/transfers/make </td>
    		<td>POST</td>
    	</tr>
    	</thead>
    </table>

