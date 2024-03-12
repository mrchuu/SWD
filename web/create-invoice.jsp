<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
                integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                crossorigin="anonymous">
            <link rel="stylesheet" href="./css/index.css" />
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
                integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
                crossorigin="anonymous" referrerpolicy="no-referrer" />

            <link rel="stylesheet" href="https://cdn.datatables.net/2.0.2/css/dataTables.dataTables.css" />
            <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
            <title>Document</title>
        </head>

        <body>
            <div class="header">
                <div class="header-banner">
                    <div class="header-banner-logo">
                        <img class="header-banner-image" src="./image/image 37.png" />
                    </div>
                    <div class="header-banner-cover">
                        <img class="header-banner-image" src="./image/image 39.png" />
                    </div>
                </div>
                <div class="header-navbar">
                    <div class="container">
                        <div class="row">
                            <div class="col header-navbar-item text-bolder">TRANG CHÚ</div>
                            <div class="col header-navbar-item text-green text-bolder">
                                DANH SÁCH BỆNH NHÂN
                            </div>
                            <div class="col header-navbar-item">ABCABC</div>
                            <div class="col header-navbar-item">ABCABC</div>
                            <div class="col header-navbar-item">ABCABC</div>
                            <div class="col header-navbar-item">
                                <img class="header-navbar-avatar" src="./image/4aa9c9b01116e715f0b1b7476df8ac0a.png" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="body">
                <div class="container">
                    <div class="body-info">
                        <div class="body-info-item">
                            <div class="body-info-item-container">
                                <div class="d-flex form-inputs">
                                    <input class="form-control" type="text"
                                        placeholder="Nhập từ khoá cần tìm kiếm..." />
                                    <i class="fa fa-search"></i>
                                </div>
                            </div>
                        </div>
                        <div class="body-info-item">
                            <div class="body-info-item-location">
                                <div class="body-info-item-location-container">
                                    <div class="body-info-item-location-item">TOÀN HỆ THỐNG</div>
                                    <div class="body-info-item-location-item">HÀ NỘI</div>
                                    <div class="body-info-item-location-item">TP.HCM</div>
                                    <div class="body-info-item-location-item">HỆ THỐNG</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="body-table" style="margin-bottom: 30px">
                        <div class="table-container">
                            <table class="display compact" id="listPatient">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Tên</th>
                                        <th scope="col">Địa chỉ</th>
                                        <th scope="col">Tình trạng hiện tại</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.listPatient}" var="patient">
                                        <tr>
                                            <th scope="row">${patient.patientId}</th>
                                            <td>${patient.name}</td>
                                            <td>${patient.address}</td>
                                            <td>${patient.statusName}</td>
                                            <td>
                                                <div class="table-detail">
                                                    <div class="table-detail-item blue"
                                                        onclick="handleInvoiceDetail(${patient.patientId})"
                                                        data-toggle="modal" data-target="#exampleModal">
                                                        XEM CHI TIẾT
                                                    </div>

                                                </div>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog"
                aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Chi tiết dịch vụ sử dụng</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body" id="invoice-detail">

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                            <button type="button" class="btn btn-primary" onclick="handleCreateInvoice()">Tạo hóa đơn</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="footer">
                <div class="container">
                    <div class="row">
                        <div class="col footer-info">
                            <div class="footer-info-item">
                                <i class="fa fa-phone-square"></i>
                                <p>19001089</p>
                            </div>
                            <div class="footer-info-item">
                                <i class="fa fa-envelope"></i>
                                <p>swd392@gmail.com</p>
                            </div>
                            <div class="footer-info-item">
                                <i class="fas fa-map-marker-alt"></i>
                                <p>Đại Học FPT, Thạch Thất, Hòa Lạc</p>
                            </div>
                        </div>
                        <div class="col footer-info">
                            <div class="footer-info-item pointer">TRANG CHỦ</div>
                            <div class="footer-info-item pointer">GIỚI THIỆU</div>
                            <div class="footer-info-item pointer">CHUYÊN KHOA</div>
                            <div class="footer-info-item pointer">DÀNH CHO NGƯỜI BỆNH</div>
                            <div class="footer-info-item pointer">HOẠT ĐỘNG TRỌNG TÂM</div>
                            <div class="footer-info-item pointer">TIN TỨC</div>
                        </div>
                        <div class="col">
                            <div class="footer-info-item">HÃY LIÊN HỆ VỚI CHÚNG TÔI</div>
                            <div class="footer-info-item">
                                <div class="footer-info-item-logo">
                                    <a href="#">
                                        <img class=""
                                            src="https://clipartspub.com/images/facebook-logo-clipart-vector-8.png" />
                                    </a>
                                    <a href="#">
                                        <img src="https://logos.edu.mx/wp-content/uploads/2021/01/YouTube-LOGO.png" />
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </body>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>


        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.datatables.net/2.0.2/js/dataTables.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>

            $(document).ready(function () {
                new DataTable('#listPatient');
               
            });
            var patientIdChoosed;
            const handleInvoiceDetail = (patientId) => {
                patientIdChoosed = patientId;
                $.ajax({
                    url: 'invoiceDetailAjax',
                    type: 'get',
                    data: {
                        patientId
                    },
                    success: function (response) {
                        console.log(response);
                        $("#invoice-detail").html(response);
                    },
                    error: function (xhr) {

                    }
                })
            }

            const handleCreateInvoice = () => {
                console.log('patientIdChoosed', patientIdChoosed);
                $.ajax({
                    url: 'createInvoiceAjax',
                    type: 'get',
                    data: {
                        patientId: patientIdChoosed
                    },
                    success: function (response) {
                        Toastify({
                            text: "Tạo hóa đơn thành công",
                            duration: 3000,
                            close: true,
                            gravity: "top",
                            position: "right",
                            backgroundColor: "linear-gradient(to right, #4CAF50, #45a049)",
                            stopOnFocus: true
                        }).showToast();
                    },
                    error: function (xhr) {
                        Toastify({
                            text: "Không thể tạo hóa đơn, vui lòng chuyển trạng thái bệnh nhân!",
                            duration: 3000,
                            close: true,
                            gravity: "top",
                            position: "right",
                            backgroundColor: "linear-gradient(to right, #FF5733, #FF5733)",
                            stopOnFocus: true
                        }).showToast();
                    }
                })
            }

        </script>


        </html>