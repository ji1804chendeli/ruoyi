import request from '@/utils/request'

// 查询工作性质列表
export function listNature(query) {
  return request({
    url: '/common/nature/list',
    method: 'get',
    params: query
  })
}

// 查询工作性质详细
export function getNature(natureid) {
  return request({
    url: '/common/nature/' + natureid,
    method: 'get'
  })
}

// 新增工作性质
export function addNature(data) {
  return request({
    url: '/common/nature',
    method: 'post',
    data: data
  })
}

// 修改工作性质
export function updateNature(data) {
  return request({
    url: '/common/nature',
    method: 'put',
    data: data
  })
}

// 删除工作性质
export function delNature(natureid) {
  return request({
    url: '/common/nature/' + natureid,
    method: 'delete'
  })
}

// 导出工作性质
export function exportNature(query) {
  return request({
    url: '/common/nature/export',
    method: 'get',
    params: query
  })
}