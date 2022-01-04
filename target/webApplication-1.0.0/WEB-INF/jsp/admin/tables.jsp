<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/layout.jsp" %>
    
    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">공지사항</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                           <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                        aria-label="Search" aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <div class="mb-4">
                                    <a href="#" class="btn btn-success btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-check"></i>
                                        </span>
                                        <span class="text">신규등록</span>
                                    </a>
                                </div>
                                <table class="table table-bordered dataTable striped" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>no..</th>
                                            <th>공지여부</th>
                                            <th>제목</th>
                                            <th>등록일시</th>
                                            <th>조회수</th>
                                            <th>아이피</th>
                                            <th>관리</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>15</td>
                                            <td>Y</td>
                                            <td>망설이면 품절, 빙산마켓에서 모아페이하세요!</td>
                                            <td>2021-02-14 12:30:41</td>
                                            <td>61</td>
                                            <td>183.110.110.111</td>
                                            <td>
                                                <a href="#" class="btn btn-primary btn-icon-split btn-sm"><span class="text">수정</span></a>
                                                <a href="#" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="paging_wrap">
                                    <a href="" class="active">1</a>
                                    <a href="">2</a>
                                    <a href="">3</a>
                                    <a href="">4</a>
                                    <a href="">5</a>
                                </div>
                            </div>
                        </div>
                    </div>
    
    <%@ include file="/admin/admin_footer.jsp" %>