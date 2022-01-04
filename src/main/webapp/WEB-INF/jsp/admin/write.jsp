<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/layout.jsp" %>
    
    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">공지사항</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <th scope="row" style="width: 120px;">공지여부</th>
											<td><label><input type="radio" name="yorn"> Y</label><label><input type="radio" name="yorn"> N</label></td>
                                        </tr>
										<tr>
                                            <th scope="row">제목</th>
											<td><input></td>
                                        </tr>
										<tr>
                                            <th scope="row">내용</th>
											<td><input></td>
                                        </tr>
										<tr>
                                            <th scope="row">등록일시</th>
											<td><input></td>
                                        </tr>
										<tr>
                                            <th scope="row">조회수</th>
											<td><input></td>
                                        </tr>
										<tr>
                                            <th scope="row">이미지</th>
											<td><input type="file"></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="btn_wrap">
                                    <a href="#" class="btn btn-primary btn-icon-split"><span class="text">등록확인</span></a>
                                    <a href="#" class="btn btn-secondary btn-icon-split"><span class="text">목록</span></a>
                                </div>
                            </div>
                        </div>
                    </div>
    
    <%@ include file="/admin/admin_footer.jsp" %>