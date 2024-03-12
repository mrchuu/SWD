<%-- 
    Document   : MedicalItems
    Created on : Mar 12, 2024, 2:25:32 PM
    Author     : FPT
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <div class="w-full h-16 bg-[#08172B] flex z-10 shadow-lg border-b border-white/50 justify-between">
            <div class="flex w-2/12 items-center justify-left px-3">
                <img src="https://res.cloudinary.com/djzdhtdpj/image/upload/v1710258969/v987-18a_1_b3flgq.png" class="w-14 h-14"/>
                <span class="text-xl text-[#F2785C] font-semibold">Vien Quan Y 105</span>
            </div>
            <div class="flex w-2/12 items-center justify-end px-10">
                <i class="fa-solid fa-gear fa-xl text-[#ADADAD] mr-5"></i>
                <i class="fa-solid fa-circle-user fa-xl text-[#ADADAD]"></i>
            </div>
        </div>
        <div class="w-full min-h-screen wrap flex">

            <div class="sideBar w-2/12 h-screen bg-[#08172B] border-r border-slate-500/50">
                <h4 class="text-[#FFFFFF] text-xl px-5  my-5 underline">Manager</h4>
                <div class="w-11/12 mx-auto px-3 py-2 rounded-md">
                    <span class="text-lg text-[#ADADAD] ">Manger DashBoard</span>
                </div>
                <div class="w-11/12 mx-auto bg-[#172A46] px-3 py-2 rounded-md">
                    <span class="text-lg text-[#ADADAD] ">Medical Items</span>
                </div>
                <div class="w-11/12 mx-auto px-3 py-2 rounded-md">
                    <span class="text-lg text-[#ADADAD] ">Patient Bed</span>
                </div>
                <div class="w-11/12 mx-auto px-3 py-2 rounded-md">
                    <span class="text-lg text-[#ADADAD] ">Patient Service</span>
                </div>
            </div>
            <div class="w-10/12 bg-[#08172B] px-10">
                <h4 class="text-[#FFFFFF] text-xl mt-10">Medical Items </h4>
                <table class="table mx-auto mt-5 w-full">
                    <thead class="border border-collapse border border-slate-500">
                        <tr class="bg-green-400 ">
                            <th scope="col" class="w-1/12 border border-slate-600">#</th>
                            <th scope="col" class="w-3/12 text-left border border-slate-600 pl-5">Name</th>
                            <th scope="col" class="w-2/12 border border-slate-600">Image</th>
                            <th scope="col" class="w-2/12 text-left border border-slate-600 pl-5">Provider</th>
                            <th scope="col" class="w-2/12 text-left border border-slate-600 pl-5">Storage</th>
                            <th scope="col" class="w-1/12 border border-slate-600">Quantity</th>
                            <th scope="col" class="w-1/12 border border-slate-600"></th>
                        </tr>
                    </thead>
                    <tbody class="text-[#ADADAD]">
                        <c:forEach items="${requestScope.medicalItemsOfStorage}" var="medicalItems" varStatus="index">
                            <tr id="item_${medicalItems.getMedicalItemId()}">
                                <td class="w-1/12 text-center border border-slate-700">${index.index + 1}</td>
                                <td class="w-3/12 border border-slate-700 pl-5 overflow-hidden" style="white-space: nowrap;">${medicalItems.getName()}</td>
                                <td class="w-2/12 border border-slate-700 overflow-hidden"><img src="${medicalItems.getImage()}" class="mx-auto"
                                                                                                style="width: 70px; height: 70px; object-position: center; object-fit: cover" alt="alt" />
                                </td>
                                <td class="w-2/12 border border-slate-700 px-5 overflow-hidden" style="white-space: nowrap;">${medicalItems.getProvider()}</td>
                                <td class="w-2/12 border border-slate-700 pl-5 overflow-hidden">Kho ${medicalItems.getStorage().getStorageCode()}</td>
                                <td class="w-1/12 text-center border border-slate-700 overflow-hidden">${medicalItems.getQuantity()}</td>
                                <td class="w-1/12 text-center border border-slate-700">
                                    <button onclick="toggleEdit(${medicalItems.getMedicalItemId()}, '${medicalItems.name}', '${medicalItems.image}', '${medicalItems.provider}', '${medicalItems.storage.storageCode}', ${medicalItems.quantity})">Edit</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>

        </div>
        <div id="toast" class="absolute hidden top-20 right-0 h-14 w-52 text-white">

        </div>
    </body>
    <script>
        function toggleEdit(itemId, name, image, provider, quantity) {
            const row = document.getElementById(`item_` + itemId);
            console.log(itemId);
            const cells = row.getElementsByTagName('td');
            cells[2].innerHTML = "";
            cells[2].innerText = image;
            // Loop through each td, excluding the ones you want to keep non-editable
            for (let i = 1; i < 4; i++) {
                cells[i].setAttribute('contenteditable', true);
            }
            cells[5].setAttribute('contenteditable', true);
            // Replace the "Edit" button with a "Save" button
            const editButton = cells[cells.length - 1].getElementsByTagName('button')[0];
            editButton.textContent = 'Save';
            editButton.onclick = function () {
                saveChanges(itemId);
            };
        }





        function saveChanges(itemId) {
            const row = document.getElementById(`item_` + itemId);
            const cells = row.getElementsByTagName('td');

            const formData = new FormData();
            formData.append("name", cells[1].innerText);
            formData.append("image", cells[2].innerText);
            formData.append("provider", cells[3].innerText);
            formData.append("quantity", cells[5].innerText);
            formData.append("id", itemId);

            const xhr = new XMLHttpRequest();

            // Configure it to send a POST request to the server
            xhr.open('POST', '/MedicalItemController', true);
            const toast = document.getElementById("toast");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        toast.classList.add("bg-green-400")
                        toast.innerText = xhr.responseText;
                    } else {
                        toast.classList.add("bg-red-400")
                        toast.innerText = xhr.responseText;
                    }
                    toast.classList.remove("hidden")
                    setTimeout(function () {
                        location.reload();
                    }, 2000);
                }
            };

            // Send the request with the FormData
            xhr.send(formData);
        }


        //    </script>
</html>
