/*
 * Copyright 2015 Evgeny Dolganov (evgenij.dolganov@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package och.front.web.servlet.system_api.admin;

import static och.api.model.user.UserRole.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import och.api.model.EmptyReq;
import och.api.model.billing.LastSyncInfo;
import och.comp.web.annotation.RoleSecured;
import och.front.web.JsonPostServlet;

@RoleSecured(ADMIN)
@WebServlet("/system-api/admin/billing/lastSyncInfo")
@SuppressWarnings("serial")
public class LastBillingSyncInfo extends JsonPostServlet<EmptyReq, LastSyncInfo> {
	
	public LastBillingSyncInfo() {
		this.checkInputDataForEmpty = false;
	}
	
	@Override
	protected LastSyncInfo doJsonPost(HttpServletRequest req, HttpServletResponse resp, EmptyReq data) throws Throwable {
		
		LastSyncInfo result = app.admin.getLastSyncInfo();
		
		return result;
	}
}
