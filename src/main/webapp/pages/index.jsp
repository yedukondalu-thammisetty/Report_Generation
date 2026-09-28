<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Citizen Plan Search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .search-box {
            border: 2px solid #333;
            padding: 30px;
            margin-top: 20px;
            border-radius: 8px;
        }
        .export-label {
            font-weight: bold;
            font-size: 1.1rem;
        }
        .btn-outline-custom {
            color: #0d6efd;
            border-color: #0d6efd;
        }
    </style>
</head>
<body class="bg-light">

<div class="container">
    <div class="search-box bg-white shadow-sm">
<form:form action="search" method="POST" modelAttribute="search">
            <div class="row mb-4">
                <div class="col-md-4">
                    <div class="row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold">Plan Name:</label>
                        <div class="col-sm-8">
								<form:select path="planName" class="form-select">
									<form:option value="">- Select -</form:option>
									<form:options items="${planNames}" />
								</form:select>
							</div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold text-nowrap">Plan Status:</label>
                        <div class="col-sm-8">
								<form:select path="planStatus" class="form-select">
									<form:option value="">- Select -</form:option>
									<form:options items="${planStatuses}" />
								</form:select>
							</div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold">Gender:</label>
                        <div class="col-sm-8">
								<form:select path="gender" class="form-select">
									<form:option value="">- Select -</form:option>
									<form:option value="Fe-Male">Fe-Male</form:option>
									<form:option value="Male">Male</form:option>
								</form:select>
							</div>
                    </div>
                </div>
            </div>

            <div class="row mb-4 align-items-center">
                <div class="col-md-4">
                    <div class="row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold text-nowrap">Start Date:</label>
                        <div class="col-sm-8">
                          <form:input path="planStartDate" type="date" class="form-control" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold text-nowrap">End Date:</label>
                        <div class="col-sm-8">
                           <form:input path="planEndDate" type="date" class="form-control" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <button type="submit" class="btn btn-outline-primary px-5 fw-bold">Search</button>
                </div>
            </div>
</form:form>
        <hr class="my-4">

        <div class="table-responsive">
            <c:choose>
                <c:when test="${not empty plans}">
                    <table class="table table-bordered table-striped table-hover align-middle">
                        <thead class="table-dark">
                            <tr>
                                <th>S.No</th>
                                <th>Holder Name</th>
                                <th>Plan Name</th>
                                <th>Status</th>
                                <th>Gender</th>
                                <th>Benefit</th>
                                <th>PlanStartDate</th>
                                <th>PlanEndDate</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${plans}" var="plan" varStatus="index">
                                <tr>
                                    <td>${index.count}</td>
                                    <td>${plan.citizenName}</td>
                                    <td>${plan.citizenPlanName}</td>
                                    <td>${plan.citizenPlanStatus}</td>
                                    <td>${plan.citizenGender}</td>
                                    <td>${plan.citizenBenefitAmount}</td>
                                    <td>${plan.citizenPlanStartDate}</td>
                                    <td>${plan.citizenPlanEndDate}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <div class="text-center py-3 text-primary">
                        &lt;With search results No Records Found&gt;
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
<p class="text-success">${msg}</p>
        <div class="mt-4">
            <span class="export-label">Export :</span>
            <a href="/excel" class="btn btn-link text-decoration-underline p-0 ms-2">Excel</a>
            <a href="/pdf" class="btn btn-link text-decoration-underline p-0 ms-2">Pdf</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>